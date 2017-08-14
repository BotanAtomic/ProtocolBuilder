package com.ankamagames.dofus.network.messages.game.guild.tax;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorFightersInformation;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorListMessage extends AbstractTaxCollectorListMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int nbcollectorMax = 0;
  public Vector<TaxCollectorFightersInformation> fightersInformations;
  private FuncTree _fightersInformationstree;
  public static final int protocolId = 5930;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.informations.length);
    int _loc2_ = 0;
    while (_loc2_ < this.informations.length) {
      param1.writeShort(((TaxCollectorInformations) (this.informations[_loc2_])).getTypeId());
      ((TaxCollectorInformations) this.informations[_loc2_]).serialize(param1);
      _loc2_++;
    }

    if (this.nbcollectorMax < 0) {
      throw new Exception(
          "Forbidden value (" + this.nbcollectorMax + ") on element nbcollectorMax.");
    }
    param1.writeByte(this.nbcollectorMax);
    param1.writeShort(this.fightersInformations.length);
    int _loc2_ = 0;
    while (_loc2_ < this.fightersInformations.length) {
      ((TaxCollectorFightersInformation) this.fightersInformations[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    TaxCollectorFightersInformation _loc4_ = null;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.nbcollectorMax = param1.readByte();
    if (this.nbcollectorMax < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbcollectorMax
              + ") on element of TaxCollectorListMessage.nbcollectorMax.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new TaxCollectorFightersInformation();
      _loc4_.deserialize(param1);
      this.fightersInformations.push(_loc4_);
      _loc3_++;
    }
  }
}
