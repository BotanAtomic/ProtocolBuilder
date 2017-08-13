package package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceModificationEmblemValidMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6447;
    private boolean _isInitialized = false;
    private GuildEmblem Alliancemblem = ;
    private FuncTree _Alliancemblemtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6447;
    }

    public AllianceModificationEmblemValidMessage initAllianceModificationEmblemValidMessage(GuildEmblem param1) {
         this.Alliancemblem = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
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
         this.serializeAs_AllianceModificationEmblemValidMessage(param1);
    }

    public void serializeAs_AllianceModificationEmblemValidMessage(ICustomDataOutput param1) {
         this.Alliancemblem.serializeAs_GuildEmblem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceModificationEmblemValidMessage(param1);
    }

    public void deserializeAs_AllianceModificationEmblemValidMessage(ICustomDataInput param1) {
         this.Alliancemblem = new GuildEmblem();
         this.Alliancemblem.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceModificationEmblemValidMessage(param1);
    }

    public void deserializeAsyncAs_AllianceModificationEmblemValidMessage(FuncTree param1) {
         this._Alliancemblemtree = param1.addChild(this._AlliancemblemtreeFunc);
    }

    private void _AlliancemblemtreeFunc(ICustomDataInput param1) {
         this.Alliancemblem = new GuildEmblem();
         this.Alliancemblem.deserializeAsync(this._Alliancemblemtree);
    }

}