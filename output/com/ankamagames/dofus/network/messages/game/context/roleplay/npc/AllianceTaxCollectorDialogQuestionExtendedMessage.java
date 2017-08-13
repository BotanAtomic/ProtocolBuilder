package package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceTaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionExtendedMessage implements INetworkMessage {

    private int protocolId = 6445;
    private boolean _isInitialized = false;
    private BasicNamedAllianceInformations alliance = ;
    private FuncTree _alliancetree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6445;
    }

    public AllianceTaxCollectorDialogQuestionExtendedMessage initAllianceTaxCollectorDialogQuestionExtendedMessage(BasicGuildInformations param1,int  param2,int  param3,int  param4,int  param5,int  param6,Number  param7,Number  param8,int  param9,Number  param10,BasicNamedAllianceInformations  param11) {
         super.initTaxCollectorDialogQuestionExtendedMessage(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10);
         this.alliance = param11;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.alliance = new BasicNamedAllianceInformations();
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
         this.serializeAs_AllianceTaxCollectorDialogQuestionExtendedMessage(param1);
    }

    public void serializeAs_AllianceTaxCollectorDialogQuestionExtendedMessage(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorDialogQuestionExtendedMessage(param1);
         this.alliance.serializeAs_BasicNamedAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceTaxCollectorDialogQuestionExtendedMessage(param1);
    }

    public void deserializeAs_AllianceTaxCollectorDialogQuestionExtendedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.alliance = new BasicNamedAllianceInformations();
         this.alliance.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceTaxCollectorDialogQuestionExtendedMessage(param1);
    }

    public void deserializeAsyncAs_AllianceTaxCollectorDialogQuestionExtendedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._alliancetree = param1.addChild(this._alliancetreeFunc);
    }

    private void _alliancetreeFunc(ICustomDataInput param1) {
         this.alliance = new BasicNamedAllianceInformations();
         this.alliance.deserializeAsync(this._alliancetree);
    }

}