package package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AllianceInvitedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6397;
    private boolean _isInitialized = false;
    private Number recruterId = 0;
    private String recruterName = "";
    private BasicNamedAllianceInformations allianceInfo = ;
    private FuncTree _allianceInfotree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6397;
    }

    public AllianceInvitedMessage initAllianceInvitedMessage(Number param1,String  param2,BasicNamedAllianceInformations  param3) {
         this.recruterId = param1;
         this.recruterName = param2;
         this.allianceInfo = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.recruterId = 0;
         this.recruterName = "";
         this.allianceInfo = new BasicNamedAllianceInformations();
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
         this.serializeAs_AllianceInvitedMessage(param1);
    }

    public void serializeAs_AllianceInvitedMessage(ICustomDataOutput param1) {
         if(this.recruterId < 0 || this.recruterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.recruterId + ") on element recruterId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceInvitedMessage(param1);
    }

    public void deserializeAs_AllianceInvitedMessage(ICustomDataInput param1) {
         this._recruterIdFunc(param1);
         this._recruterNameFunc(param1);
         this.allianceInfo = new BasicNamedAllianceInformations();
         this.allianceInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceInvitedMessage(param1);
    }

    public void deserializeAsyncAs_AllianceInvitedMessage(FuncTree param1) {
         param1.addChild(this._recruterIdFunc);
         param1.addChild(this._recruterNameFunc);
         this._allianceInfotree = param1.addChild(this._allianceInfotreeFunc);
    }

    private void _recruterIdFunc(ICustomDataInput param1) {
         this.recruterId = param1.readVarUhLong();
         if(this.recruterId < 0 || this.recruterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.recruterId + ") on element of AllianceInvitedMessage.recruterId.");
    }

    private void _recruterNameFunc(ICustomDataInput param1) {
         this.recruterName = param1.readUTF();
    }

    private void _allianceInfotreeFunc(ICustomDataInput param1) {
         this.allianceInfo = new BasicNamedAllianceInformations();
         this.allianceInfo.deserializeAsync(this._allianceInfotree);
    }

}