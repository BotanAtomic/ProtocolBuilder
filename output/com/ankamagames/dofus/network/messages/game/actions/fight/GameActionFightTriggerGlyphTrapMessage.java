package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightTriggerGlyphTrapMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5741;
    private boolean _isInitialized = false;
    private int markId = 0;
    private Number triggeringCharacterId = 0;
    private int triggeredSpellId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5741;
    }

    public GameActionFightTriggerGlyphTrapMessage initGameActionFightTriggerGlyphTrapMessage(int param1,Number  param2,int  param3,Number  param4,int  param5) {
         super.initAbstractGameActionMessage(param1,param2);
         this.markId = param3;
         this.triggeringCharacterId = param4;
         this.triggeredSpellId = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.markId = 0;
         this.triggeringCharacterId = 0;
         this.triggeredSpellId = 0;
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
         this.serializeAs_GameActionFightTriggerGlyphTrapMessage(param1);
    }

    public void serializeAs_GameActionFightTriggerGlyphTrapMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         param1.writeShort(this.markId);
         if(this.triggeringCharacterId < -9.007199254740992E15 || this.triggeringCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.triggeringCharacterId + ") on element triggeringCharacterId.");
         }
         param1.writeDouble(this.triggeringCharacterId);
         if(this.triggeredSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.triggeredSpellId + ") on element triggeredSpellId.");
         }
         param1.writeVarShort(this.triggeredSpellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightTriggerGlyphTrapMessage(param1);
    }

    public void deserializeAs_GameActionFightTriggerGlyphTrapMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._markIdFunc(param1);
         this._triggeringCharacterIdFunc(param1);
         this._triggeredSpellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightTriggerGlyphTrapMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightTriggerGlyphTrapMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._markIdFunc);
         param1.addChild(this._triggeringCharacterIdFunc);
         param1.addChild(this._triggeredSpellIdFunc);
    }

    private void _markIdFunc(ICustomDataInput param1) {
         this.markId = param1.readShort();
    }

    private void _triggeringCharacterIdFunc(ICustomDataInput param1) {
         this.triggeringCharacterId = param1.readDouble();
         if(this.triggeringCharacterId < -9.007199254740992E15 || this.triggeringCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.triggeringCharacterId + ") on element of GameActionFightTriggerGlyphTrapMessage.triggeringCharacterId.");
         }
    }

    private void _triggeredSpellIdFunc(ICustomDataInput param1) {
         this.triggeredSpellId = param1.readVarUhShort();
         if(this.triggeredSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.triggeredSpellId + ") on element of GameActionFightTriggerGlyphTrapMessage.triggeredSpellId.");
         }
    }

}