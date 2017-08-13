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

public class SpellVariantActivationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6705;
    private boolean _isInitialized = false;
    private boolean result = false;
    private int activatedSpellId = 0;
    private int deactivatedSpellId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6705;
    }

    public SpellVariantActivationMessage initSpellVariantActivationMessage(boolean param1,int  param2,int  param3) {
         this.result = param1;
         this.activatedSpellId = param2;
         this.deactivatedSpellId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.result = false;
         this.activatedSpellId = 0;
         this.deactivatedSpellId = 0;
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
         this.serializeAs_SpellVariantActivationMessage(param1);
    }

    public void serializeAs_SpellVariantActivationMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.result);
         if(this.activatedSpellId < 0)
            throw new Exception("Forbidden value (" + this.activatedSpellId + ") on element activatedSpellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SpellVariantActivationMessage(param1);
    }

    public void deserializeAs_SpellVariantActivationMessage(ICustomDataInput param1) {
         this._resultFunc(param1);
         this._activatedSpellIdFunc(param1);
         this._deactivatedSpellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SpellVariantActivationMessage(param1);
    }

    public void deserializeAsyncAs_SpellVariantActivationMessage(FuncTree param1) {
         param1.addChild(this._resultFunc);
         param1.addChild(this._activatedSpellIdFunc);
         param1.addChild(this._deactivatedSpellIdFunc);
    }

    private void _resultFunc(ICustomDataInput param1) {
         this.result = param1.readBoolean();
    }

    private void _activatedSpellIdFunc(ICustomDataInput param1) {
         this.activatedSpellId = param1.readVarUhShort();
         if(this.activatedSpellId < 0)
            throw new Exception("Forbidden value (" + this.activatedSpellId + ") on element of SpellVariantActivationMessage.activatedSpellId.");
    }

    private void _deactivatedSpellIdFunc(ICustomDataInput param1) {
         this.deactivatedSpellId = param1.readVarUhShort();
         if(this.deactivatedSpellId < 0)
            throw new Exception("Forbidden value (" + this.deactivatedSpellId + ") on element of SpellVariantActivationMessage.deactivatedSpellId.");
    }

}