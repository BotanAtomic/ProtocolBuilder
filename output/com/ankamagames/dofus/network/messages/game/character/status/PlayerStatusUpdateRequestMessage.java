package package com.ankamagames.dofus.network.messages.game.character.status;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class PlayerStatusUpdateRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6387;
    private boolean _isInitialized = false;
    private PlayerStatus status = ;
    private FuncTree _statustree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6387;
    }

    public PlayerStatusUpdateRequestMessage initPlayerStatusUpdateRequestMessage(PlayerStatus param1) {
         this.status = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.status = new PlayerStatus();
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
         this.serializeAs_PlayerStatusUpdateRequestMessage(param1);
    }

    public void serializeAs_PlayerStatusUpdateRequestMessage(ICustomDataOutput param1) {
         param1.writeShort(this.status.getTypeId());
         this.status.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PlayerStatusUpdateRequestMessage(param1);
    }

    public void deserializeAs_PlayerStatusUpdateRequestMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PlayerStatusUpdateRequestMessage(param1);
    }

    public void deserializeAsyncAs_PlayerStatusUpdateRequestMessage(FuncTree param1) {
         this._statustree = param1.addChild(this._statustreeFunc);
    }

    private void _statustreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserializeAsync(this._statustree);
    }

}