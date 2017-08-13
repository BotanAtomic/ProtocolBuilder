package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformationsForGuild;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildHouseUpdateInformationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6181;
    private boolean _isInitialized = false;
    private HouseInformationsForGuild housesInformations = ;
    private FuncTree _housesInformationstree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6181;
    }

    public GuildHouseUpdateInformationMessage initGuildHouseUpdateInformationMessage(HouseInformationsForGuild param1) {
         this.housesInformations = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.housesInformations = new HouseInformationsForGuild();
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
         this.serializeAs_GuildHouseUpdateInformationMessage(param1);
    }

    public void serializeAs_GuildHouseUpdateInformationMessage(ICustomDataOutput param1) {
         this.housesInformations.serializeAs_HouseInformationsForGuild(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildHouseUpdateInformationMessage(param1);
    }

    public void deserializeAs_GuildHouseUpdateInformationMessage(ICustomDataInput param1) {
         this.housesInformations = new HouseInformationsForGuild();
         this.housesInformations.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildHouseUpdateInformationMessage(param1);
    }

    public void deserializeAsyncAs_GuildHouseUpdateInformationMessage(FuncTree param1) {
         this._housesInformationstree = param1.addChild(this._housesInformationstreeFunc);
    }

    private void _housesInformationstreeFunc(ICustomDataInput param1) {
         this.housesInformations = new HouseInformationsForGuild();
         this.housesInformations.deserializeAsync(this._housesInformationstree);
    }

}