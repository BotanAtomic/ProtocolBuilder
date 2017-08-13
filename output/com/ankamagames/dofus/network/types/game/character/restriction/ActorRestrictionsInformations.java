package package com.ankamagames.dofus.network.types.game.character.restriction;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ActorRestrictionsInformations extends Object implements INetworkType {

    private int protocolId = 204;
    private boolean cantBeAggressed = false;
    private boolean cantBeChallenged = false;
    private boolean cantTrade = false;
    private boolean cantBeAttackedByMutant = false;
    private boolean cantRun = false;
    private boolean forceSlowWalk = false;
    private boolean cantMinimize = false;
    private boolean cantMove = false;
    private boolean cantAggress = false;
    private boolean cantChallenge = false;
    private boolean cantExchange = false;
    private boolean cantAttack = false;
    private boolean cantChat = false;
    private boolean cantBeMerchant = false;
    private boolean cantUseObject = false;
    private boolean cantUseTaxCollector = false;
    private boolean cantUseInteractive = false;
    private boolean cantSpeakToNPC = false;
    private boolean cantChangeZone = false;
    private boolean cantAttackMonster = false;
    private boolean cantWalk8Directions = false;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private int _loc3_ = param1.readByte();
    private int _loc4_ = param1.readByte();


    public int getTypeId() {
         return 204;
    }

    public ActorRestrictionsInformations initActorRestrictionsInformations(boolean param1,boolean  param2,boolean  param3,boolean  param4,boolean  param5,boolean  param6,boolean  param7,boolean  param8,boolean  param9,boolean  param10,boolean  param11,boolean  param12,boolean  param13,boolean  param14,boolean  param15,boolean  param16,boolean  param17,boolean  param18,boolean  param19,boolean  param20,boolean  param21) {
         this.cantBeAggressed = param1;
         this.cantBeChallenged = param2;
         this.cantTrade = param3;
         this.cantBeAttackedByMutant = param4;
         this.cantRun = param5;
         this.forceSlowWalk = param6;
         this.cantMinimize = param7;
         this.cantMove = param8;
         this.cantAggress = param9;
         this.cantChallenge = param10;
         this.cantExchange = param11;
         this.cantAttack = param12;
         this.cantChat = param13;
         this.cantBeMerchant = param14;
         this.cantUseObject = param15;
         this.cantUseTaxCollector = param16;
         this.cantUseInteractive = param17;
         this.cantSpeakToNPC = param18;
         this.cantChangeZone = param19;
         this.cantAttackMonster = param20;
         this.cantWalk8Directions = param21;
         return this;
    }

    public void reset() {
         this.cantBeAggressed = false;
         this.cantBeChallenged = false;
         this.cantTrade = false;
         this.cantBeAttackedByMutant = false;
         this.cantRun = false;
         this.forceSlowWalk = false;
         this.cantMinimize = false;
         this.cantMove = false;
         this.cantAggress = false;
         this.cantChallenge = false;
         this.cantExchange = false;
         this.cantAttack = false;
         this.cantChat = false;
         this.cantBeMerchant = false;
         this.cantUseObject = false;
         this.cantUseTaxCollector = false;
         this.cantUseInteractive = false;
         this.cantSpeakToNPC = false;
         this.cantChangeZone = false;
         this.cantAttackMonster = false;
         this.cantWalk8Directions = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ActorRestrictionsInformations(param1);
    }

    public void serializeAs_ActorRestrictionsInformations(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.cantBeAggressed);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.cantBeChallenged);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.cantTrade);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.cantBeAttackedByMutant);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,4,this.cantRun);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,5,this.forceSlowWalk);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,6,this.cantMinimize);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,7,this.cantMove);
         param1.writeByte(_loc2_);
         int _loc3_ = 0;
         _loc3_ = BooleanByteWrapper.setFlag(_loc3_,0,this.cantAggress);
         _loc3_ = BooleanByteWrapper.setFlag(_loc3_,1,this.cantChallenge);
         _loc3_ = BooleanByteWrapper.setFlag(_loc3_,2,this.cantExchange);
         _loc3_ = BooleanByteWrapper.setFlag(_loc3_,3,this.cantAttack);
         _loc3_ = BooleanByteWrapper.setFlag(_loc3_,4,this.cantChat);
         _loc3_ = BooleanByteWrapper.setFlag(_loc3_,5,this.cantBeMerchant);
         _loc3_ = BooleanByteWrapper.setFlag(_loc3_,6,this.cantUseObject);
         _loc3_ = BooleanByteWrapper.setFlag(_loc3_,7,this.cantUseTaxCollector);
         param1.writeByte(_loc3_);
         int _loc4_ = 0;
         _loc4_ = BooleanByteWrapper.setFlag(_loc4_,0,this.cantUseInteractive);
         _loc4_ = BooleanByteWrapper.setFlag(_loc4_,1,this.cantSpeakToNPC);
         _loc4_ = BooleanByteWrapper.setFlag(_loc4_,2,this.cantChangeZone);
         _loc4_ = BooleanByteWrapper.setFlag(_loc4_,3,this.cantAttackMonster);
         _loc4_ = BooleanByteWrapper.setFlag(_loc4_,4,this.cantWalk8Directions);
         param1.writeByte(_loc4_);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ActorRestrictionsInformations(param1);
    }

    public void deserializeAs_ActorRestrictionsInformations(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ActorRestrictionsInformations(param1);
    }

    public void deserializeAsyncAs_ActorRestrictionsInformations(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.cantBeAggressed = BooleanByteWrapper.getFlag(_loc2_,0);
         this.cantBeChallenged = BooleanByteWrapper.getFlag(_loc2_,1);
         this.cantTrade = BooleanByteWrapper.getFlag(_loc2_,2);
         this.cantBeAttackedByMutant = BooleanByteWrapper.getFlag(_loc2_,3);
         this.cantRun = BooleanByteWrapper.getFlag(_loc2_,4);
         this.forceSlowWalk = BooleanByteWrapper.getFlag(_loc2_,5);
         this.cantMinimize = BooleanByteWrapper.getFlag(_loc2_,6);
         this.cantMove = BooleanByteWrapper.getFlag(_loc2_,7);
         int _loc3_ = param1.readByte();
         this.cantAggress = BooleanByteWrapper.getFlag(_loc3_,0);
         this.cantChallenge = BooleanByteWrapper.getFlag(_loc3_,1);
         this.cantExchange = BooleanByteWrapper.getFlag(_loc3_,2);
         this.cantAttack = BooleanByteWrapper.getFlag(_loc3_,3);
         this.cantChat = BooleanByteWrapper.getFlag(_loc3_,4);
         this.cantBeMerchant = BooleanByteWrapper.getFlag(_loc3_,5);
         this.cantUseObject = BooleanByteWrapper.getFlag(_loc3_,6);
         this.cantUseTaxCollector = BooleanByteWrapper.getFlag(_loc3_,7);
         int _loc4_ = param1.readByte();
         this.cantUseInteractive = BooleanByteWrapper.getFlag(_loc4_,0);
         this.cantSpeakToNPC = BooleanByteWrapper.getFlag(_loc4_,1);
         this.cantChangeZone = BooleanByteWrapper.getFlag(_loc4_,2);
         this.cantAttackMonster = BooleanByteWrapper.getFlag(_loc4_,3);
         this.cantWalk8Directions = BooleanByteWrapper.getFlag(_loc4_,4);
    }

}