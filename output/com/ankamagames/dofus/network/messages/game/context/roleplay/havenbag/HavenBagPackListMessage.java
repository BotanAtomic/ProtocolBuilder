package package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HavenBagPackListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6620;
    private boolean _isInitialized = false;
    private Vector.<int> packIds = ;
    private FuncTree _packIdstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6620;
    }

    public HavenBagPackListMessage initHavenBagPackListMessage(Vector.<int> param1) {
         this.packIds = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.packIds = new Vector.<int>();
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
         this.serializeAs_HavenBagPackListMessage(param1);
    }

    public void serializeAs_HavenBagPackListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.packIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.packIds.length)
            param1.writeByte(this.packIds[_loc2_]);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HavenBagPackListMessage(param1);
    }

    public void deserializeAs_HavenBagPackListMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readByte();
            this.packIds.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HavenBagPackListMessage(param1);
    }

    public void deserializeAsyncAs_HavenBagPackListMessage(FuncTree param1) {
         this._packIdstree = param1.addChild(this._packIdstreeFunc);
    }

    private void _packIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._packIdstree.addChild(this._packIdsFunc);
            _loc3_++;
    }

    private void _packIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.packIds.push(_loc2_);
    }

}