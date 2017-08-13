package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.GameRolePlayNpcQuestFlag;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayNpcWithQuestInformations extends GameRolePlayNpcInformations implements INetworkType {

    private int protocolId = 383;
    private GameRolePlayNpcQuestFlag questFlag;
    private FuncTree _questFlagtree;


    public int getTypeId() {
         return 383;
    }

    public GameRolePlayNpcWithQuestInformations initGameRolePlayNpcWithQuestInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,boolean  param5,int  param6,GameRolePlayNpcQuestFlag  param7) {
         super.initGameRolePlayNpcInformations(param1,param2,param3,param4,param5,param6);
         this.questFlag = param7;
         return this;
    }

    public void reset() {
         super.reset();
         this.questFlag = new GameRolePlayNpcQuestFlag();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayNpcWithQuestInformations(param1);
    }

    public void serializeAs_GameRolePlayNpcWithQuestInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayNpcInformations(param1);
         this.questFlag.serializeAs_GameRolePlayNpcQuestFlag(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayNpcWithQuestInformations(param1);
    }

    public void deserializeAs_GameRolePlayNpcWithQuestInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.questFlag = new GameRolePlayNpcQuestFlag();
         this.questFlag.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayNpcWithQuestInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayNpcWithQuestInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._questFlagtree = param1.addChild(this._questFlagtreeFunc);
    }

    private void _questFlagtreeFunc(ICustomDataInput param1) {
         this.questFlag = new GameRolePlayNpcQuestFlag();
         this.questFlag.deserializeAsync(this._questFlagtree);
    }

}