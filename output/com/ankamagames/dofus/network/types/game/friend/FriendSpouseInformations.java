package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FriendSpouseInformations extends Object implements INetworkType {

    private int protocolId = 77;
    private int spouseAccountId = 0;
    private Number spouseId = 0;
    private String spouseName = "";
    private int spouseLevel = 0;
    private int breed = 0;
    private int sex = 0;
    private EntityLook spouseEntityLook;
    private GuildInformations guildInfo;
    private int alignmentSide = 0;
    private FuncTree _spouseEntityLooktree;
    private FuncTree _guildInfotree;


    public void serialize(ICustomDataOutput param1) {
         if(this.spouseAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.spouseAccountId + ") on element spouseAccountId.");
         }
         param1.writeInt(this.spouseAccountId);
         if(this.spouseId < 0 || this.spouseId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.spouseId + ") on element spouseId.");
         }
         param1.writeVarLong(this.spouseId);
         param1.writeUTF(this.spouseName);
         if(this.spouseLevel < 1 || this.spouseLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.spouseLevel + ") on element spouseLevel.");
         }
         param1.writeByte(this.spouseLevel);
         param1.writeByte(this.breed);
         param1.writeByte(this.sex);
         this.spouseEntityLook.serializeAs_EntityLook(param1);
         this.guildInfo.serializeAs_GuildInformations(param1);
         param1.writeByte(this.alignmentSide);
    }

    public void deserialize(ICustomDataInput param1) {
         this.spouseAccountId = param1.readInt();
         if(this.spouseAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.spouseAccountId + ") on element of FriendSpouseInformations.spouseAccountId.");
         }
         this.spouseId = param1.readVarUhLong();
         if(this.spouseId < 0 || this.spouseId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.spouseId + ") on element of FriendSpouseInformations.spouseId.");
         }
         this.spouseName = param1.readUTF();
         this.spouseLevel = param1.readUnsignedByte();
         if(this.spouseLevel < 1 || this.spouseLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.spouseLevel + ") on element of FriendSpouseInformations.spouseLevel.");
         }
         this.breed = param1.readByte();
         this.sex = param1.readByte();
         this.spouseEntityLook = new EntityLook();
         this.spouseEntityLook.deserialize(param1);
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this.alignmentSide = param1.readByte();
    }

}