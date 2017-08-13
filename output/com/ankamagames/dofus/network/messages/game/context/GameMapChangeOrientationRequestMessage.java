package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameMapChangeOrientationRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 945;
    private boolean _isInitialized = false;
    private int direction = 1;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 945;
    }

    public GameMapChangeOrientationRequestMessage initGameMapChangeOrientationRequestMessage(int param1) {
         this.direction = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.direction = 1;
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
         this.serializeAs_GameMapChangeOrientationRequestMessage(param1);
    }

    public void serializeAs_GameMapChangeOrientationRequestMessage(ICustomDataOutput param1) {
         param1.writeByte(this.direction);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameMapChangeOrientationRequestMessage(param1);
    }

    public void deserializeAs_GameMapChangeOrientationRequestMessage(ICustomDataInput param1) {
         this._directionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameMapChangeOrientationRequestMessage(param1);
    }

    public void deserializeAsyncAs_GameMapChangeOrientationRequestMessage(FuncTree param1) {
         param1.addChild(this._directionFunc);
    }

    private void _directionFunc(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of GameMapChangeOrientationRequestMessage.direction.");
         }
    }

}