package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayHumanoidInformations extends GameRolePlayNamedActorInformations implements INetworkType {

    private int protocolId = 159;
    private HumanInformations humanoidInfo;
    private int accountId = 0;
    private FuncTree _humanoidInfotree;


    public int getTypeId() {
         return 159;
    }

    public GameRolePlayHumanoidInformations initGameRolePlayHumanoidInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,String  param4,HumanInformations  param5,int  param6) {
         super.initGameRolePlayNamedActorInformations(param1,param2,param3,param4);
         this.humanoidInfo = param5;
         this.accountId = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.humanoidInfo = new HumanInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayHumanoidInformations(param1);
    }

    public void serializeAs_GameRolePlayHumanoidInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayNamedActorInformations(param1);
         param1.writeShort(this.humanoidInfo.getTypeId());
         this.humanoidInfo.serialize(param1);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayHumanoidInformations(param1);
    }

    public void deserializeAs_GameRolePlayHumanoidInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.humanoidInfo = ProtocolTypeManager.getInstance(HumanInformations,_loc2_);
         this.humanoidInfo.deserialize(param1);
         this._accountIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayHumanoidInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayHumanoidInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._humanoidInfotree = param1.addChild(this._humanoidInfotreeFunc);
         param1.addChild(this._accountIdFunc);
    }

    private void _humanoidInfotreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.humanoidInfo = ProtocolTypeManager.getInstance(HumanInformations,_loc2_);
         this.humanoidInfo.deserializeAsync(this._humanoidInfotree);
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of GameRolePlayHumanoidInformations.accountId.");
         }
    }

}