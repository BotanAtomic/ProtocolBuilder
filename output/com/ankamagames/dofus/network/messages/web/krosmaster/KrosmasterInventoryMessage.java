package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.web.krosmaster.KrosmasterFigure;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterInventoryMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<KrosmasterFigure> figures;
  private FuncTree _figurestree;
  public static final int protocolId = 6350;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.figures.length);
    int _loc2_ = 0;
    while (_loc2_ < this.figures.length) {
      ((KrosmasterFigure) this.figures[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    KrosmasterFigure _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new KrosmasterFigure();
      _loc4_.deserialize(param1);
      this.figures.push(_loc4_);
      _loc3_++;
    }
  }
}
