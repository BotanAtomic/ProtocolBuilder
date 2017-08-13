package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FriendOnlineInformations extends FriendInformations implements INetworkType {

    private int protocolId = 92;
    private Number playerId = 0;
    private String playerName = "";
    private int level = 0;
    private int alignmentSide = 0;
    private int breed = 0;
    private boolean sex = false;
    private GuildInformations guildInfo;
    private int moodSmileyId = 0;
    private PlayerStatus status;
    private boolean havenBagShared = false;
    private FuncTree _guildInfotree;
    private FuncTree _statustree;


    public int getTypeId() {
         return 92;
    }

    public FriendOnlineInformations initFriendOnlineInformations(int param1,String  param2,int  param3,int  param4,int  param5,Number  param6,String  param7,int  param8,int  param9,int  param10,boolean  param11,GuildInformations  param12,int  param13,PlayerStatus  param14,boolean  param15) {
         super.initFriendInformations(param1,param2,param3,param4,param5);
         this.playerId = param6;
         this.playerName = param7;
         this.level = param8;
         this.alignmentSide = param9;
         this.breed = param10;
         this.sex = param11;
         this.guildInfo = param12;
         this.moodSmileyId = param13;
         this.status = param14;
         this.havenBagShared = param15;
         return this;
    }

    public void reset() {
         super.reset();
         this.playerId = 0;
         this.playerName = "";
         this.level = 0;
         this.alignmentSide = 0;
         this.breed = 0;
         this.sex = false;
         this.guildInfo = new GuildInformations();
         this.status = new PlayerStatus();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FriendOnlineInformations(param1);
    }

    public void serializeAs_FriendOnlineInformations(ICustomDataOutput param1) {
         super.serializeAs_FriendInformations(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.sex);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.havenBagShared);
         param1.writeByte(_loc2_);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeUTF(this.playerName);
         if(this.level < 0 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         param1.writeByte(this.alignmentSide);
         param1.writeByte(this.breed);
         this.guildInfo.serializeAs_GuildInformations(param1);
         if(this.moodSmileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.moodSmileyId + ") on element moodSmileyId.");
         }
         param1.writeVarShort(this.moodSmileyId);
         param1.writeShort(this.status.getTypeId());
         this.status.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FriendOnlineInformations(param1);
    }

    public void deserializeAs_FriendOnlineInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.deserializeByteBoxes(param1);
         this._playerIdFunc(param1);
         this._playerNameFunc(param1);
         this._levelFunc(param1);
         this._alignmentSideFunc(param1);
         this._breedFunc(param1);
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this._moodSmileyIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FriendOnlineInformations(param1);
    }

    public void deserializeAsyncAs_FriendOnlineInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._playerNameFunc);
         param1.addChild(this._levelFunc);
         param1.addChild(this._alignmentSideFunc);
         param1.addChild(this._breedFunc);
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
         param1.addChild(this._moodSmileyIdFunc);
         this._statustree = param1.addChild(this._statustreeFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.sex = BooleanByteWrapper.getFlag(_loc2_,0);
         this.havenBagShared = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of FriendOnlineInformations.playerId.");
         }
    }

    private void _playerNameFunc(ICustomDataInput param1) {
         this.playerName = param1.readUTF();
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FriendOnlineInformations.level.");
         }
    }

    private void _alignmentSideFunc(ICustomDataInput param1) {
         this.alignmentSide = param1.readByte();
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
         if(this.breed < PlayableBreedEnum.Feca || this.breed > PlayableBreedEnum.Ouginak)
         {
            throw new Exception("Forbidden value (" + this.breed + ") on element of FriendOnlineInformations.breed.");
         }
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

    private void _moodSmileyIdFunc(ICustomDataInput param1) {
         this.moodSmileyId = param1.readVarUhShort();
         if(this.moodSmileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.moodSmileyId + ") on element of FriendOnlineInformations.moodSmileyId.");
         }
    }

    private void _statustreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserializeAsync(this._statustree);
    }

}