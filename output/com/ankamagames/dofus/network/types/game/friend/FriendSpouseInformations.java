package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
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


    public int getTypeId() {
         return 77;
    }

    public FriendSpouseInformations initFriendSpouseInformations(int param1,Number  param2,String  param3,int  param4,int  param5,int  param6,EntityLook  param7,GuildInformations  param8,int  param9) {
         this.spouseAccountId = param1;
         this.spouseId = param2;
         this.spouseName = param3;
         this.spouseLevel = param4;
         this.breed = param5;
         this.sex = param6;
         this.spouseEntityLook = param7;
         this.guildInfo = param8;
         this.alignmentSide = param9;
         return this;
    }

    public void reset() {
         this.spouseAccountId = 0;
         this.spouseId = 0;
         this.spouseName = "";
         this.spouseLevel = 0;
         this.breed = 0;
         this.sex = 0;
         this.spouseEntityLook = new EntityLook();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FriendSpouseInformations(param1);
    }

    public void serializeAs_FriendSpouseInformations(ICustomDataOutput param1) {
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
         this.deserializeAs_FriendSpouseInformations(param1);
    }

    public void deserializeAs_FriendSpouseInformations(ICustomDataInput param1) {
         this._spouseAccountIdFunc(param1);
         this._spouseIdFunc(param1);
         this._spouseNameFunc(param1);
         this._spouseLevelFunc(param1);
         this._breedFunc(param1);
         this._sexFunc(param1);
         this.spouseEntityLook = new EntityLook();
         this.spouseEntityLook.deserialize(param1);
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this._alignmentSideFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FriendSpouseInformations(param1);
    }

    public void deserializeAsyncAs_FriendSpouseInformations(FuncTree param1) {
         param1.addChild(this._spouseAccountIdFunc);
         param1.addChild(this._spouseIdFunc);
         param1.addChild(this._spouseNameFunc);
         param1.addChild(this._spouseLevelFunc);
         param1.addChild(this._breedFunc);
         param1.addChild(this._sexFunc);
         this._spouseEntityLooktree = param1.addChild(this._spouseEntityLooktreeFunc);
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
         param1.addChild(this._alignmentSideFunc);
    }

    private void _spouseAccountIdFunc(ICustomDataInput param1) {
         this.spouseAccountId = param1.readInt();
         if(this.spouseAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.spouseAccountId + ") on element of FriendSpouseInformations.spouseAccountId.");
         }
    }

    private void _spouseIdFunc(ICustomDataInput param1) {
         this.spouseId = param1.readVarUhLong();
         if(this.spouseId < 0 || this.spouseId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.spouseId + ") on element of FriendSpouseInformations.spouseId.");
         }
    }

    private void _spouseNameFunc(ICustomDataInput param1) {
         this.spouseName = param1.readUTF();
    }

    private void _spouseLevelFunc(ICustomDataInput param1) {
         this.spouseLevel = param1.readUnsignedByte();
         if(this.spouseLevel < 1 || this.spouseLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.spouseLevel + ") on element of FriendSpouseInformations.spouseLevel.");
         }
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readByte();
    }

    private void _spouseEntityLooktreeFunc(ICustomDataInput param1) {
         this.spouseEntityLook = new EntityLook();
         this.spouseEntityLook.deserializeAsync(this._spouseEntityLooktree);
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

    private void _alignmentSideFunc(ICustomDataInput param1) {
         this.alignmentSide = param1.readByte();
    }

}