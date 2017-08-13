package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightCloseCombatMessage extends AbstractGameActionFightTargetedAbilityMessage implements INetworkMessage {

    private int protocolId = 6116;
    private boolean _isInitialized = false;
    private int weaponGenericId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6116;
    }

    public GameActionFightCloseCombatMessage initGameActionFightCloseCombatMessage(int param1,Number  param2,Number  param3,int  param4,int  param5,boolean  param6,boolean  param7,int  param8) {
         super.initAbstractGameActionFightTargetedAbilityMessage(param1,param2,param3,param4,param5,param6,param7);
         this.weaponGenericId = param8;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.weaponGenericId = 0;
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
         this.serializeAs_GameActionFightCloseCombatMessage(param1);
    }

    public void serializeAs_GameActionFightCloseCombatMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionFightTargetedAbilityMessage(param1);
         if(this.weaponGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.weaponGenericId + ") on element weaponGenericId.");
         }
         param1.writeVarShort(this.weaponGenericId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightCloseCombatMessage(param1);
    }

    public void deserializeAs_GameActionFightCloseCombatMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._weaponGenericIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightCloseCombatMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightCloseCombatMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._weaponGenericIdFunc);
    }

    private void _weaponGenericIdFunc(ICustomDataInput param1) {
         this.weaponGenericId = param1.readVarUhShort();
         if(this.weaponGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.weaponGenericId + ") on element of GameActionFightCloseCombatMessage.weaponGenericId.");
         }
    }

}