package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

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

public class PartyUpdateLightMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 6054;
    private boolean _isInitialized = false;
    private Number id = 0;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int prospecting = 0;
    private int regenRate = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6054;
    }

    public PartyUpdateLightMessage initPartyUpdateLightMessage(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6) {
         super.initAbstractPartyEventMessage(param1);
         this.id = param2;
         this.lifePoints = param3;
         this.maxLifePoints = param4;
         this.prospecting = param5;
         this.regenRate = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.id = 0;
         this.lifePoints = 0;
         this.maxLifePoints = 0;
         this.prospecting = 0;
         this.regenRate = 0;
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
         this.serializeAs_PartyUpdateLightMessage(param1);
    }

    public void serializeAs_PartyUpdateLightMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarLong(this.id);
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
         }
         param1.writeVarInt(this.lifePoints);
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
         }
         param1.writeVarInt(this.maxLifePoints);
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element prospecting.");
         }
         param1.writeVarShort(this.prospecting);
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
         }
         param1.writeByte(this.regenRate);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyUpdateLightMessage(param1);
    }

    public void deserializeAs_PartyUpdateLightMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._idFunc(param1);
         this._lifePointsFunc(param1);
         this._maxLifePointsFunc(param1);
         this._prospectingFunc(param1);
         this._regenRateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyUpdateLightMessage(param1);
    }

    public void deserializeAsyncAs_PartyUpdateLightMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._idFunc);
         param1.addChild(this._lifePointsFunc);
         param1.addChild(this._maxLifePointsFunc);
         param1.addChild(this._prospectingFunc);
         param1.addChild(this._regenRateFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of PartyUpdateLightMessage.id.");
         }
    }

    private void _lifePointsFunc(ICustomDataInput param1) {
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of PartyUpdateLightMessage.lifePoints.");
         }
    }

    private void _maxLifePointsFunc(ICustomDataInput param1) {
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of PartyUpdateLightMessage.maxLifePoints.");
         }
    }

    private void _prospectingFunc(ICustomDataInput param1) {
         this.prospecting = param1.readVarUhShort();
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element of PartyUpdateLightMessage.prospecting.");
         }
    }

    private void _regenRateFunc(ICustomDataInput param1) {
         this.regenRate = param1.readUnsignedByte();
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element of PartyUpdateLightMessage.regenRate.");
         }
    }

}