package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IgnoredInformations extends AbstractContactInformations implements INetworkType {

  public static final int protocolId = 106;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    param1.writeUTF(this.accountName);
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
  }
}
