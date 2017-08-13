package package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FriendSpouseOnlineInformations extends FriendSpouseInformations implements INetworkType {

    private int protocolId = 93;
    private int mapId = 0;
    private int subAreaId = 0;
    private boolean inFight = false;
    private boolean followSpouse = false;
    private int _loc2_ = 0;


    public int getTypeId() {
         return 93;
    }

    public FriendSpouseOnlineInformations initFriendSpouseOnlineInformations(int param1,Number  param2,String  param3,int  param4,int  param5,int  param6,EntityLook  param7,GuildInformations  param8,int  param9,int  param10,int  param11,boolean  param12,boolean  param13) {
         super.initFriendSpouseInformations(param1,param2,param3,param4,param5,param6,param7,param8,param9);
         this.mapId = param10;
         this.subAreaId = param11;
         this.inFight = param12;
         this.followSpouse = param13;
         return this;
    }

    public void reset() {
         super.reset();
         this.mapId = 0;
         this.subAreaId = 0;
         this.inFight = false;
         this.followSpouse = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FriendSpouseOnlineInformations(param1);
    }

    public void serializeAs_FriendSpouseOnlineInformations(ICustomDataOutput param1) {
         super.serializeAs_FriendSpouseInformations(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.inFight);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.followSpouse);
         param1.writeByte(_loc2_);
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FriendSpouseOnlineInformations(param1);
    }

    public void deserializeAs_FriendSpouseOnlineInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.deserializeByteBoxes(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FriendSpouseOnlineInformations(param1);
    }

    public void deserializeAsyncAs_FriendSpouseOnlineInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.inFight = BooleanByteWrapper.getFlag(_loc2_,0);
         this.followSpouse = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element of FriendSpouseOnlineInformations.mapId.");
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of FriendSpouseOnlineInformations.subAreaId.");
    }

}