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
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightPlacementSwapPositionsOfferMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6542;
    private boolean _isInitialized = false;
    private int requestId = 0;
    private Number requesterId = 0;
    private int requesterCellId = 0;
    private Number requestedId = 0;
    private int requestedCellId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6542;
    }

    public GameFightPlacementSwapPositionsOfferMessage initGameFightPlacementSwapPositionsOfferMessage(int param1,Number  param2,int  param3,Number  param4,int  param5) {
         this.requestId = param1;
         this.requesterId = param2;
         this.requesterCellId = param3;
         this.requestedId = param4;
         this.requestedCellId = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.requestId = 0;
         this.requesterId = 0;
         this.requesterCellId = 0;
         this.requestedId = 0;
         this.requestedCellId = 0;
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
         this.serializeAs_GameFightPlacementSwapPositionsOfferMessage(param1);
    }

    public void serializeAs_GameFightPlacementSwapPositionsOfferMessage(ICustomDataOutput param1) {
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeInt(this.requestId);
         if(this.requesterId < -9.007199254740992E15 || this.requesterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requesterId + ") on element requesterId.");
         }
         param1.writeDouble(this.requesterId);
         if(this.requesterCellId < 0 || this.requesterCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.requesterCellId + ") on element requesterCellId.");
         }
         param1.writeVarShort(this.requesterCellId);
         if(this.requestedId < -9.007199254740992E15 || this.requestedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requestedId + ") on element requestedId.");
         }
         param1.writeDouble(this.requestedId);
         if(this.requestedCellId < 0 || this.requestedCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.requestedCellId + ") on element requestedCellId.");
         }
         param1.writeVarShort(this.requestedCellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightPlacementSwapPositionsOfferMessage(param1);
    }

    public void deserializeAs_GameFightPlacementSwapPositionsOfferMessage(ICustomDataInput param1) {
         this._requestIdFunc(param1);
         this._requesterIdFunc(param1);
         this._requesterCellIdFunc(param1);
         this._requestedIdFunc(param1);
         this._requestedCellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightPlacementSwapPositionsOfferMessage(param1);
    }

    public void deserializeAsyncAs_GameFightPlacementSwapPositionsOfferMessage(FuncTree param1) {
         param1.addChild(this._requestIdFunc);
         param1.addChild(this._requesterIdFunc);
         param1.addChild(this._requesterCellIdFunc);
         param1.addChild(this._requestedIdFunc);
         param1.addChild(this._requestedCellIdFunc);
    }

    private void _requestIdFunc(ICustomDataInput param1) {
         this.requestId = param1.readInt();
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requestId.");
         }
    }

    private void _requesterIdFunc(ICustomDataInput param1) {
         this.requesterId = param1.readDouble();
         if(this.requesterId < -9.007199254740992E15 || this.requesterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requesterId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requesterId.");
         }
    }

    private void _requesterCellIdFunc(ICustomDataInput param1) {
         this.requesterCellId = param1.readVarUhShort();
         if(this.requesterCellId < 0 || this.requesterCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.requesterCellId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requesterCellId.");
         }
    }

    private void _requestedIdFunc(ICustomDataInput param1) {
         this.requestedId = param1.readDouble();
         if(this.requestedId < -9.007199254740992E15 || this.requestedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requestedId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requestedId.");
         }
    }

    private void _requestedCellIdFunc(ICustomDataInput param1) {
         this.requestedCellId = param1.readVarUhShort();
         if(this.requestedCellId < 0 || this.requestedCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.requestedCellId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requestedCellId.");
         }
    }

}