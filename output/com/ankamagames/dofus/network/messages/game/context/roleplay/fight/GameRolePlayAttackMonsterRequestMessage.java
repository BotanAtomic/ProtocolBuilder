package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayAttackMonsterRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6191;
    private boolean _isInitialized = false;
    private Number monsterGroupId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6191;
    }

    public GameRolePlayAttackMonsterRequestMessage initGameRolePlayAttackMonsterRequestMessage(Number param1) {
         this.monsterGroupId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.monsterGroupId = 0;
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
         this.serializeAs_GameRolePlayAttackMonsterRequestMessage(param1);
    }

    public void serializeAs_GameRolePlayAttackMonsterRequestMessage(ICustomDataOutput param1) {
         if(this.monsterGroupId < -9.007199254740992E15 || this.monsterGroupId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.monsterGroupId + ") on element monsterGroupId.");
         }
         param1.writeDouble(this.monsterGroupId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayAttackMonsterRequestMessage(param1);
    }

    public void deserializeAs_GameRolePlayAttackMonsterRequestMessage(ICustomDataInput param1) {
         this._monsterGroupIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayAttackMonsterRequestMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayAttackMonsterRequestMessage(FuncTree param1) {
         param1.addChild(this._monsterGroupIdFunc);
    }

    private void _monsterGroupIdFunc(ICustomDataInput param1) {
         this.monsterGroupId = param1.readDouble();
         if(this.monsterGroupId < -9.007199254740992E15 || this.monsterGroupId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.monsterGroupId + ") on element of GameRolePlayAttackMonsterRequestMessage.monsterGroupId.");
         }
    }

}