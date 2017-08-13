package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.UpdateMountBoost;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class UpdateMountBoostMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6179;
    private boolean _isInitialized = false;
    private int rideId = 0;
    private Vector.<UpdateMountBoost> boostToUpdateList = ;
    private FuncTree _boostToUpdateListtree = ;
    private int _loc2_ = 0;
    private UpdateMountBoost _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private UpdateMountBoost _loc3_ = ProtocolTypeManager.getInstance(UpdateMountBoost,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6179;
    }

    public UpdateMountBoostMessage initUpdateMountBoostMessage(int param1,Vector.<UpdateMountBoost>  param2) {
         this.rideId = param1;
         this.boostToUpdateList = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.rideId = 0;
         this.boostToUpdateList = new Vector.<UpdateMountBoost>();
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
         this.serializeAs_UpdateMountBoostMessage(param1);
    }

    public void serializeAs_UpdateMountBoostMessage(ICustomDataOutput param1) {
         param1.writeVarInt(this.rideId);
         param1.writeShort(this.boostToUpdateList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.boostToUpdateList.length)
            param1.writeShort((this.boostToUpdateList[_loc2_] as UpdateMountBoost).getTypeId());
            (this.boostToUpdateList[_loc2_] as UpdateMountBoost).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_UpdateMountBoostMessage(param1);
    }

    public void deserializeAs_UpdateMountBoostMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         UpdateMountBoost _loc5_ = null;
         this._rideIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(UpdateMountBoost,_loc4_);
            _loc5_.deserialize(param1);
            this.boostToUpdateList.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_UpdateMountBoostMessage(param1);
    }

    public void deserializeAsyncAs_UpdateMountBoostMessage(FuncTree param1) {
         param1.addChild(this._rideIdFunc);
         this._boostToUpdateListtree = param1.addChild(this._boostToUpdateListtreeFunc);
    }

    private void _rideIdFunc(ICustomDataInput param1) {
         this.rideId = param1.readVarInt();
    }

    private void _boostToUpdateListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._boostToUpdateListtree.addChild(this._boostToUpdateListFunc);
            _loc3_++;
    }

    private void _boostToUpdateListFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         UpdateMountBoost _loc3_ = ProtocolTypeManager.getInstance(UpdateMountBoost,_loc2_);
         _loc3_.deserialize(param1);
         this.boostToUpdateList.push(_loc3_);
    }

}