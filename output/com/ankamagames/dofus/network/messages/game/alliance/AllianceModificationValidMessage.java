package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceModificationValidMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6450;
    private boolean _isInitialized = false;
    private String allianceName = "";
    private String allianceTag = "";
    private GuildEmblem Alliancemblem;
    private FuncTree _Alliancemblemtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6450;
    }

    public AllianceModificationValidMessage initAllianceModificationValidMessage(String param1,String  param2,GuildEmblem  param3) {
         this.allianceName = param1;
         this.allianceTag = param2;
         this.Alliancemblem = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.allianceName = "";
         this.allianceTag = "";
         this.Alliancemblem = new GuildEmblem();
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
         this.serializeAs_AllianceModificationValidMessage(param1);
    }

    public void serializeAs_AllianceModificationValidMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.allianceName);
         param1.writeUTF(this.allianceTag);
         this.Alliancemblem.serializeAs_GuildEmblem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceModificationValidMessage(param1);
    }

    public void deserializeAs_AllianceModificationValidMessage(ICustomDataInput param1) {
         this._allianceNameFunc(param1);
         this._allianceTagFunc(param1);
         this.Alliancemblem = new GuildEmblem();
         this.Alliancemblem.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceModificationValidMessage(param1);
    }

    public void deserializeAsyncAs_AllianceModificationValidMessage(FuncTree param1) {
         param1.addChild(this._allianceNameFunc);
         param1.addChild(this._allianceTagFunc);
         this._Alliancemblemtree = param1.addChild(this._AlliancemblemtreeFunc);
    }

    private void _allianceNameFunc(ICustomDataInput param1) {
         this.allianceName = param1.readUTF();
    }

    private void _allianceTagFunc(ICustomDataInput param1) {
         this.allianceTag = param1.readUTF();
    }

    private void _AlliancemblemtreeFunc(ICustomDataInput param1) {
         this.Alliancemblem = new GuildEmblem();
         this.Alliancemblem.deserializeAsync(this._Alliancemblemtree);
    }

}