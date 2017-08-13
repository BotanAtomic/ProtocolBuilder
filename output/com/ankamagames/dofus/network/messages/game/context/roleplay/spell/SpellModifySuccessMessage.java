package package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SpellModifySuccessMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6654;
    private boolean _isInitialized = false;
    private int spellId = 0;
    private int spellLevel = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6654;
    }

    public SpellModifySuccessMessage initSpellModifySuccessMessage(int param1,int  param2) {
         this.spellId = param1;
         this.spellLevel = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.spellId = 0;
         this.spellLevel = 0;
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
         this.serializeAs_SpellModifySuccessMessage(param1);
    }

    public void serializeAs_SpellModifySuccessMessage(ICustomDataOutput param1) {
         param1.writeInt(this.spellId);
         if(this.spellLevel < 1 || this.spellLevel > 200)
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SpellModifySuccessMessage(param1);
    }

    public void deserializeAs_SpellModifySuccessMessage(ICustomDataInput param1) {
         this._spellIdFunc(param1);
         this._spellLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SpellModifySuccessMessage(param1);
    }

    public void deserializeAsyncAs_SpellModifySuccessMessage(FuncTree param1) {
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._spellLevelFunc);
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readInt();
    }

    private void _spellLevelFunc(ICustomDataInput param1) {
         this.spellLevel = param1.readShort();
         if(this.spellLevel < 1 || this.spellLevel > 200)
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element of SpellModifySuccessMessage.spellLevel.");
    }

}