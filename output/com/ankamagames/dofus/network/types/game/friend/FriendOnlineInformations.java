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


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractContactInformations(param1);
         param1.writeByte(this.playerState);
         if(this.lastConnection < 0)
         {
            throw new Exception("Forbidden value (" + this.lastConnection + ") on element lastConnection.");
         }
         param1.writeVarShort(this.lastConnection);
         param1.writeInt(this.achievementPoints);
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
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of AbstractContactInformations.accountId.");
         }
         this.accountName = param1.readUTF();
         this.playerState = param1.readByte();
         if(this.playerState < 0)
         {
            throw new Exception("Forbidden value (" + this.playerState + ") on element of FriendInformations.playerState.");
         }
         this.lastConnection = param1.readVarUhShort();
         if(this.lastConnection < 0)
         {
            throw new Exception("Forbidden value (" + this.lastConnection + ") on element of FriendInformations.lastConnection.");
         }
         this.achievementPoints = param1.readInt();
         int _loc2_ = param1.readByte();
         this.sex = BooleanByteWrapper.getFlag(_loc2_,0);
         this.havenBagShared = BooleanByteWrapper.getFlag(_loc2_,1);
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of FriendOnlineInformations.playerId.");
         }
         this.playerName = param1.readUTF();
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FriendOnlineInformations.level.");
         }
         this.alignmentSide = param1.readByte();
         this.breed = param1.readByte();
         if(this.breed < PlayableBreedEnum.Feca || this.breed > PlayableBreedEnum.Ouginak)
         {
            throw new Exception("Forbidden value (" + this.breed + ") on element of FriendOnlineInformations.breed.");
         }
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this.moodSmileyId = param1.readVarUhShort();
         if(this.moodSmileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.moodSmileyId + ") on element of FriendOnlineInformations.moodSmileyId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
    }

}