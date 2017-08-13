package package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
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

public class TaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionBasicMessage implements INetworkMessage {

    private int protocolId = 5615;
    private boolean _isInitialized = false;
    private int maxPods = 0;
    private int prospecting = 0;
    private int wisdom = 0;
    private int taxCollectorsCount = 0;
    private int taxCollectorAttack = 0;
    private Number kamas = 0;
    private Number experience = 0;
    private int pods = 0;
    private Number itemsValue = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5615;
    }

    public TaxCollectorDialogQuestionExtendedMessage initTaxCollectorDialogQuestionExtendedMessage(BasicGuildInformations param1,int  param2,int  param3,int  param4,int  param5,int  param6,Number  param7,Number  param8,int  param9,Number  param10) {
         super.initTaxCollectorDialogQuestionBasicMessage(param1);
         this.maxPods = param2;
         this.prospecting = param3;
         this.wisdom = param4;
         this.taxCollectorsCount = param5;
         this.taxCollectorAttack = param6;
         this.kamas = param7;
         this.experience = param8;
         this.pods = param9;
         this.itemsValue = param10;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.maxPods = 0;
         this.prospecting = 0;
         this.wisdom = 0;
         this.taxCollectorsCount = 0;
         this.taxCollectorAttack = 0;
         this.kamas = 0;
         this.experience = 0;
         this.pods = 0;
         this.itemsValue = 0;
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
         this.serializeAs_TaxCollectorDialogQuestionExtendedMessage(param1);
    }

    public void serializeAs_TaxCollectorDialogQuestionExtendedMessage(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorDialogQuestionBasicMessage(param1);
         if(this.maxPods < 0)
            throw new Exception("Forbidden value (" + this.maxPods + ") on element maxPods.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorDialogQuestionExtendedMessage(param1);
    }

    public void deserializeAs_TaxCollectorDialogQuestionExtendedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._maxPodsFunc(param1);
         this._prospectingFunc(param1);
         this._wisdomFunc(param1);
         this._taxCollectorsCountFunc(param1);
         this._taxCollectorAttackFunc(param1);
         this._kamasFunc(param1);
         this._experienceFunc(param1);
         this._podsFunc(param1);
         this._itemsValueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorDialogQuestionExtendedMessage(param1);
    }

    public void deserializeAsyncAs_TaxCollectorDialogQuestionExtendedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._maxPodsFunc);
         param1.addChild(this._prospectingFunc);
         param1.addChild(this._wisdomFunc);
         param1.addChild(this._taxCollectorsCountFunc);
         param1.addChild(this._taxCollectorAttackFunc);
         param1.addChild(this._kamasFunc);
         param1.addChild(this._experienceFunc);
         param1.addChild(this._podsFunc);
         param1.addChild(this._itemsValueFunc);
    }

    private void _maxPodsFunc(ICustomDataInput param1) {
         this.maxPods = param1.readVarUhShort();
         if(this.maxPods < 0)
            throw new Exception("Forbidden value (" + this.maxPods + ") on element of TaxCollectorDialogQuestionExtendedMessage.maxPods.");
    }

    private void _prospectingFunc(ICustomDataInput param1) {
         this.prospecting = param1.readVarUhShort();
         if(this.prospecting < 0)
            throw new Exception("Forbidden value (" + this.prospecting + ") on element of TaxCollectorDialogQuestionExtendedMessage.prospecting.");
    }

    private void _wisdomFunc(ICustomDataInput param1) {
         this.wisdom = param1.readVarUhShort();
         if(this.wisdom < 0)
            throw new Exception("Forbidden value (" + this.wisdom + ") on element of TaxCollectorDialogQuestionExtendedMessage.wisdom.");
    }

    private void _taxCollectorsCountFunc(ICustomDataInput param1) {
         this.taxCollectorsCount = param1.readByte();
         if(this.taxCollectorsCount < 0)
            throw new Exception("Forbidden value (" + this.taxCollectorsCount + ") on element of TaxCollectorDialogQuestionExtendedMessage.taxCollectorsCount.");
    }

    private void _taxCollectorAttackFunc(ICustomDataInput param1) {
         this.taxCollectorAttack = param1.readInt();
    }

    private void _kamasFunc(ICustomDataInput param1) {
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.kamas + ") on element of TaxCollectorDialogQuestionExtendedMessage.kamas.");
    }

    private void _experienceFunc(ICustomDataInput param1) {
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element of TaxCollectorDialogQuestionExtendedMessage.experience.");
    }

    private void _podsFunc(ICustomDataInput param1) {
         this.pods = param1.readVarUhInt();
         if(this.pods < 0)
            throw new Exception("Forbidden value (" + this.pods + ") on element of TaxCollectorDialogQuestionExtendedMessage.pods.");
    }

    private void _itemsValueFunc(ICustomDataInput param1) {
         this.itemsValue = param1.readVarUhLong();
         if(this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.itemsValue + ") on element of TaxCollectorDialogQuestionExtendedMessage.itemsValue.");
    }

}