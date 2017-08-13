package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightPlacementSwapPositionsRequestMessage extends GameFightPlacementPositionRequestMessage implements INetworkMessage {

    private int protocolId = 6541;
    private boolean _isInitialized = false;
    private Number requestedId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6541;
    }

    public GameFightPlacementSwapPositionsRequestMessage initGameFightPlacementSwapPositionsRequestMessage(int param1,Number  param2) {
         super.initGameFightPlacementPositionRequestMessage(param1);
         this.requestedId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.requestedId = 0;
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
         this.serializeAs_GameFightPlacementSwapPositionsRequestMessage(param1);
    }

    public void serializeAs_GameFightPlacementSwapPositionsRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_GameFightPlacementPositionRequestMessage(param1);
         if(this.requestedId < -9.007199254740992E15 || this.requestedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requestedId + ") on element requestedId.");
         }
         param1.writeDouble(this.requestedId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightPlacementSwapPositionsRequestMessage(param1);
    }

    public void deserializeAs_GameFightPlacementSwapPositionsRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._requestedIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightPlacementSwapPositionsRequestMessage(param1);
    }

    public void deserializeAsyncAs_GameFightPlacementSwapPositionsRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._requestedIdFunc);
    }

    private void _requestedIdFunc(ICustomDataInput param1) {
         this.requestedId = param1.readDouble();
         if(this.requestedId < -9.007199254740992E15 || this.requestedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requestedId + ") on element of GameFightPlacementSwapPositionsRequestMessage.requestedId.");
         }
    }

}