package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.dofus.network.messages.game.social.SocialNoticeSetRequestMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceBulletinSetRequestMessage extends SocialNoticeSetRequestMessage implements INetworkMessage {

    private int protocolId = 6693;
    private boolean _isInitialized = false;
    private String content = "";
    private boolean notifyMembers = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6693;
    }

    public AllianceBulletinSetRequestMessage initAllianceBulletinSetRequestMessage(String param1,boolean  param2) {
         this.content = param1;
         this.notifyMembers = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.content = "";
         this.notifyMembers = false;
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
         this.serializeAs_AllianceBulletinSetRequestMessage(param1);
    }

    public void serializeAs_AllianceBulletinSetRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_SocialNoticeSetRequestMessage(param1);
         param1.writeUTF(this.content);
         param1.writeBoolean(this.notifyMembers);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceBulletinSetRequestMessage(param1);
    }

    public void deserializeAs_AllianceBulletinSetRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._contentFunc(param1);
         this._notifyMembersFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceBulletinSetRequestMessage(param1);
    }

    public void deserializeAsyncAs_AllianceBulletinSetRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._contentFunc);
         param1.addChild(this._notifyMembersFunc);
    }

    private void _contentFunc(ICustomDataInput param1) {
         this.content = param1.readUTF();
    }

    private void _notifyMembersFunc(ICustomDataInput param1) {
         this.notifyMembers = param1.readBoolean();
    }

}