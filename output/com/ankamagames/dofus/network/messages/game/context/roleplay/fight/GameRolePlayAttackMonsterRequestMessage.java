package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayAttackMonsterRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6191;
    private boolean _isInitialized = false;
    private Number monsterGroupId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.monsterGroupId < -9.007199254740992E15 || this.monsterGroupId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.monsterGroupId + ") on element monsterGroupId.");
         }
         param1.writeDouble(this.monsterGroupId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.monsterGroupId = param1.readDouble();
         if(this.monsterGroupId < -9.007199254740992E15 || this.monsterGroupId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.monsterGroupId + ") on element of GameRolePlayAttackMonsterRequestMessage.monsterGroupId.");
         }
    }

}