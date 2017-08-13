package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.dofus.network.types.game.social.GuildFactSheetInformations;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInAllianceFactsMessage extends GuildFactsMessage implements INetworkMessage {

    private int protocolId = 6422;
    private boolean _isInitialized = false;
    private BasicNamedAllianceInformations allianceInfos;
    private FuncTree _allianceInfostree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6422;
    }

    public GuildInAllianceFactsMessage initGuildInAllianceFactsMessage(GuildFactSheetInformations param1,int  param2,int  param3,Vector<CharacterMinimalInformations>  param4,BasicNamedAllianceInformations  param5) {
         super.initGuildFactsMessage(param1,param2,param3,param4);
         this.allianceInfos = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.allianceInfos = new BasicNamedAllianceInformations();
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
         this.serializeAs_GuildInAllianceFactsMessage(param1);
    }

    public void serializeAs_GuildInAllianceFactsMessage(ICustomDataOutput param1) {
         super.serializeAs_GuildFactsMessage(param1);
         this.allianceInfos.serializeAs_BasicNamedAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInAllianceFactsMessage(param1);
    }

    public void deserializeAs_GuildInAllianceFactsMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.allianceInfos = new BasicNamedAllianceInformations();
         this.allianceInfos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInAllianceFactsMessage(param1);
    }

    public void deserializeAsyncAs_GuildInAllianceFactsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._allianceInfostree = param1.addChild(this._allianceInfostreeFunc);
    }

    private void _allianceInfostreeFunc(ICustomDataInput param1) {
         this.allianceInfos = new BasicNamedAllianceInformations();
         this.allianceInfos.deserializeAsync(this._allianceInfostree);
    }

}