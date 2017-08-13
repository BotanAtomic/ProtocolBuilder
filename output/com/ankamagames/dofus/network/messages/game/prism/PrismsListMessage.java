package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.prism.PrismSubareaEmptyInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class PrismsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6440;
    private boolean _isInitialized = false;
    private Vector<PrismSubareaEmptyInfo> prisms;
    private FuncTree _prismstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6440;
    }

    public PrismsListMessage initPrismsListMessage(Vector<PrismSubareaEmptyInfo> param1) {
         this.prisms = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.prisms = new Vector.<PrismSubareaEmptyInfo>();
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
         this.serializeAs_PrismsListMessage(param1);
    }

    public void serializeAs_PrismsListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.prisms.length);
         int _loc2_ = 0;
         while(_loc2_ < this.prisms.length)
         {
            param1.writeShort((this.prisms[_loc2_] as PrismSubareaEmptyInfo).getTypeId());
            (this.prisms[_loc2_] as PrismSubareaEmptyInfo).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismsListMessage(param1);
    }

    public void deserializeAs_PrismsListMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         PrismSubareaEmptyInfo _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(PrismSubareaEmptyInfo,_loc4_);
            _loc5_.deserialize(param1);
            this.prisms.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismsListMessage(param1);
    }

    public void deserializeAsyncAs_PrismsListMessage(FuncTree param1) {
         this._prismstree = param1.addChild(this._prismstreeFunc);
    }

    private void _prismstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._prismstree.addChild(this._prismsFunc);
            _loc3_++;
         }
    }

    private void _prismsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         PrismSubareaEmptyInfo _loc3_ = ProtocolTypeManager.getInstance(PrismSubareaEmptyInfo,_loc2_);
         _loc3_.deserialize(param1);
         this.prisms.push(_loc3_);
    }

}