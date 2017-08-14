package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.fight.ProtectedEntityWaitingForHelpInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorWaitingForHelpInformations extends TaxCollectorComplementaryInformations
    implements INetworkType {

  public ProtectedEntityWaitingForHelpInfo waitingForHelpInfo;
  private FuncTree _waitingForHelpInfotree;
  public static final int protocolId = 447;

  @Override
  public void serialize(ICustomDataOutput param1) {

    this.waitingForHelpInfo.serializeAs_ProtectedEntityWaitingForHelpInfo(param1);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
    this.waitingForHelpInfo.deserialize(param1);
  }
}
