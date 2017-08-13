package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.updater.ContentPart;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1502;
    private boolean _isInitialized = false;
    private Vector<ContentPart> parts;
    private FuncTree _partstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1502;
    }

    public PartsListMessage initPartsListMessage(Vector<ContentPart> param1) {
         this.parts = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.parts = new Vector.<ContentPart>();
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
         this.serializeAs_PartsListMessage(param1);
    }

    public void serializeAs_PartsListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.parts.length);
         int _loc2_ = 0;
         while(_loc2_ < this.parts.length)
         {
            (this.parts[_loc2_] as ContentPart).serializeAs_ContentPart(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartsListMessage(param1);
    }

    public void deserializeAs_PartsListMessage(ICustomDataInput param1) {
         ContentPart _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ContentPart();
            _loc4_.deserialize(param1);
            this.parts.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartsListMessage(param1);
    }

    public void deserializeAsyncAs_PartsListMessage(FuncTree param1) {
         this._partstree = param1.addChild(this._partstreeFunc);
    }

    private void _partstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._partstree.addChild(this._partsFunc);
            _loc3_++;
         }
    }

    private void _partsFunc(ICustomDataInput param1) {
         ContentPart _loc2_ = new ContentPart();
         _loc2_.deserialize(param1);
         this.parts.push(_loc2_);
    }

}