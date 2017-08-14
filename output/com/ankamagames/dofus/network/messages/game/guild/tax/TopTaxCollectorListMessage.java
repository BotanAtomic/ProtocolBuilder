package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TopTaxCollectorListMessage extends AbstractTaxCollectorListMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean isDungeon = false;
  public static final int protocolId = 6565;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.informations.length);
    int _loc2_ = 0;
    while (_loc2_ < this.informations.length) {
      param1.writeShort(((TaxCollectorInformations) (this.informations[_loc2_])).getTypeId());
      ((TaxCollectorInformations) this.informations[_loc2_]).serialize(param1);
      _loc2_++;
    }

    param1.writeBoolean(this.isDungeon);
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

    this.isDungeon = param1.readBoolean();
  }
}
