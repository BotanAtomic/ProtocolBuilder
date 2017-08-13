package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapNoMovementMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 954;
    private boolean _isInitialized = false;
    private int cellX = 0;
    private int cellY = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 954;
    }

    public GameMapNoMovementMessage initGameMapNoMovementMessage(int param1,int  param2) {
         this.cellX = param1;
         this.cellY = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cellX = 0;
         this.cellY = 0;
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
         this.serializeAs_GameMapNoMovementMessage(param1);
    }

    public void serializeAs_GameMapNoMovementMessage(ICustomDataOutput param1) {
         param1.writeShort(this.cellX);
         param1.writeShort(this.cellY);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameMapNoMovementMessage(param1);
    }

    public void deserializeAs_GameMapNoMovementMessage(ICustomDataInput param1) {
         this._cellXFunc(param1);
         this._cellYFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameMapNoMovementMessage(param1);
    }

    public void deserializeAsyncAs_GameMapNoMovementMessage(FuncTree param1) {
         param1.addChild(this._cellXFunc);
         param1.addChild(this._cellYFunc);
    }

    private void _cellXFunc(ICustomDataInput param1) {
         this.cellX = param1.readShort();
    }

    private void _cellYFunc(ICustomDataInput param1) {
         this.cellY = param1.readShort();
    }

}