package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformationsForGuild;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildHousesInformationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5919;
    private boolean _isInitialized = false;
    private Vector<HouseInformationsForGuild> housesInformations;
    private FuncTree _housesInformationstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5919;
    }

    public GuildHousesInformationMessage initGuildHousesInformationMessage(Vector<HouseInformationsForGuild> param1) {
         this.housesInformations = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.housesInformations = new Vector.<HouseInformationsForGuild>();
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
         this.serializeAs_GuildHousesInformationMessage(param1);
    }

    public void serializeAs_GuildHousesInformationMessage(ICustomDataOutput param1) {
         param1.writeShort(this.housesInformations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.housesInformations.length)
         {
            (this.housesInformations[_loc2_] as HouseInformationsForGuild).serializeAs_HouseInformationsForGuild(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildHousesInformationMessage(param1);
    }

    public void deserializeAs_GuildHousesInformationMessage(ICustomDataInput param1) {
         HouseInformationsForGuild _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new HouseInformationsForGuild();
            _loc4_.deserialize(param1);
            this.housesInformations.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildHousesInformationMessage(param1);
    }

    public void deserializeAsyncAs_GuildHousesInformationMessage(FuncTree param1) {
         this._housesInformationstree = param1.addChild(this._housesInformationstreeFunc);
    }

    private void _housesInformationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._housesInformationstree.addChild(this._housesInformationsFunc);
            _loc3_++;
         }
    }

    private void _housesInformationsFunc(ICustomDataInput param1) {
         HouseInformationsForGuild _loc2_ = new HouseInformationsForGuild();
         _loc2_.deserialize(param1);
         this.housesInformations.push(_loc2_);
    }

}