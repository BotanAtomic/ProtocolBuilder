package package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class SpellItemBoostMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6011;
    private boolean _isInitialized = false;
    private int statId = 0;
    private int spellId = 0;
    private int value = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6011;
    }

    public SpellItemBoostMessage initSpellItemBoostMessage(int param1,int  param2,int  param3) {
         this.statId = param1;
         this.spellId = param2;
         this.value = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.statId = 0;
         this.spellId = 0;
         this.value = 0;
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
         this.serializeAs_SpellItemBoostMessage(param1);
    }

    public void serializeAs_SpellItemBoostMessage(ICustomDataOutput param1) {
         if(this.statId < 0)
            throw new Exception("Forbidden value (" + this.statId + ") on element statId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SpellItemBoostMessage(param1);
    }

    public void deserializeAs_SpellItemBoostMessage(ICustomDataInput param1) {
         this._statIdFunc(param1);
         this._spellIdFunc(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SpellItemBoostMessage(param1);
    }

    public void deserializeAsyncAs_SpellItemBoostMessage(FuncTree param1) {
         param1.addChild(this._statIdFunc);
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._valueFunc);
    }

    private void _statIdFunc(ICustomDataInput param1) {
         this.statId = param1.readVarUhInt();
         if(this.statId < 0)
            throw new Exception("Forbidden value (" + this.statId + ") on element of SpellItemBoostMessage.statId.");
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element of SpellItemBoostMessage.spellId.");
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readVarShort();
    }

}