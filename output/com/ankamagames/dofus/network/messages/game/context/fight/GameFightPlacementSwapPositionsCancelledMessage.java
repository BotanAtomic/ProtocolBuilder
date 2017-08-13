package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightPlacementSwapPositionsCancelledMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6546;
    private boolean _isInitialized = false;
    private int requestId = 0;
    private Number cancellerId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6546;
    }

    public GameFightPlacementSwapPositionsCancelledMessage initGameFightPlacementSwapPositionsCancelledMessage(int param1,Number  param2) {
         this.requestId = param1;
         this.cancellerId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.requestId = 0;
         this.cancellerId = 0;
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
         this.serializeAs_GameFightPlacementSwapPositionsCancelledMessage(param1);
    }

    public void serializeAs_GameFightPlacementSwapPositionsCancelledMessage(ICustomDataOutput param1) {
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeInt(this.requestId);
         if(this.cancellerId < -9.007199254740992E15 || this.cancellerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.cancellerId + ") on element cancellerId.");
         }
         param1.writeDouble(this.cancellerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightPlacementSwapPositionsCancelledMessage(param1);
    }

    public void deserializeAs_GameFightPlacementSwapPositionsCancelledMessage(ICustomDataInput param1) {
         this._requestIdFunc(param1);
         this._cancellerIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightPlacementSwapPositionsCancelledMessage(param1);
    }

    public void deserializeAsyncAs_GameFightPlacementSwapPositionsCancelledMessage(FuncTree param1) {
         param1.addChild(this._requestIdFunc);
         param1.addChild(this._cancellerIdFunc);
    }

    private void _requestIdFunc(ICustomDataInput param1) {
         this.requestId = param1.readInt();
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of GameFightPlacementSwapPositionsCancelledMessage.requestId.");
         }
    }

    private void _cancellerIdFunc(ICustomDataInput param1) {
         this.cancellerId = param1.readDouble();
         if(this.cancellerId < -9.007199254740992E15 || this.cancellerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.cancellerId + ") on element of GameFightPlacementSwapPositionsCancelledMessage.cancellerId.");
         }
    }

}