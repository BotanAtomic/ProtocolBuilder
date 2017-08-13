package package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildFightTakePlaceRequestMessage extends GuildFightJoinRequestMessage implements INetworkMessage {

    private int protocolId = 6235;
    private boolean _isInitialized = false;
    private int replacedCharacterId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6235;
    }

    public GuildFightTakePlaceRequestMessage initGuildFightTakePlaceRequestMessage(int param1,int  param2) {
         super.initGuildFightJoinRequestMessage(param1);
         this.replacedCharacterId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.replacedCharacterId = 0;
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
         this.serializeAs_GuildFightTakePlaceRequestMessage(param1);
    }

    public void serializeAs_GuildFightTakePlaceRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_GuildFightJoinRequestMessage(param1);
         param1.writeInt(this.replacedCharacterId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildFightTakePlaceRequestMessage(param1);
    }

    public void deserializeAs_GuildFightTakePlaceRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._replacedCharacterIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildFightTakePlaceRequestMessage(param1);
    }

    public void deserializeAsyncAs_GuildFightTakePlaceRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._replacedCharacterIdFunc);
    }

    private void _replacedCharacterIdFunc(ICustomDataInput param1) {
         this.replacedCharacterId = param1.readInt();
    }

}