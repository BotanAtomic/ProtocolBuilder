package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.web.krosmaster.KrosmasterFigure;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterInventoryMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6350;
    private boolean _isInitialized = false;
    private Vector<KrosmasterFigure> figures;
    private FuncTree _figurestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6350;
    }

    public KrosmasterInventoryMessage initKrosmasterInventoryMessage(Vector<KrosmasterFigure> param1) {
         this.figures = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.figures = new Vector.<KrosmasterFigure>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_KrosmasterInventoryMessage(param1);
    }

    public void serializeAs_KrosmasterInventoryMessage(ICustomDataOutput param1) {
         param1.writeShort(this.figures.length);
         int _loc2_ = 0;
         while(_loc2_ < this.figures.length)
         {
            (this.figures[_loc2_] as KrosmasterFigure).serializeAs_KrosmasterFigure(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_KrosmasterInventoryMessage(param1);
    }

    public void deserializeAs_KrosmasterInventoryMessage(ICustomDataInput param1) {
         KrosmasterFigure _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new KrosmasterFigure();
            _loc4_.deserialize(param1);
            this.figures.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_KrosmasterInventoryMessage(param1);
    }

    public void deserializeAsyncAs_KrosmasterInventoryMessage(FuncTree param1) {
         this._figurestree = param1.addChild(this._figurestreeFunc);
    }

    private void _figurestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._figurestree.addChild(this._figuresFunc);
            _loc3_++;
         }
    }

    private void _figuresFunc(ICustomDataInput param1) {
         KrosmasterFigure _loc2_ = new KrosmasterFigure();
         _loc2_.deserialize(param1);
         this.figures.push(_loc2_);
    }

}