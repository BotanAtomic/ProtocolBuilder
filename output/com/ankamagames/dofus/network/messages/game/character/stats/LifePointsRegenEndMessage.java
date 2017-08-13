package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LifePointsRegenEndMessage extends UpdateLifePointsMessage implements INetworkMessage {

    private int protocolId = 5686;
    private boolean _isInitialized = false;
    private int lifePointsGained = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
         }
         param1.writeVarInt(this.lifePoints);
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
         }
         param1.writeVarInt(this.maxLifePoints);
         if(this.lifePointsGained < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePointsGained + ") on element lifePointsGained.");
         }
         param1.writeVarInt(this.lifePointsGained);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_UpdateLifePointsMessage(param1);
         this.lifePointsGained = param1.readVarUhInt();
         if(this.lifePointsGained < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePointsGained + ") on element of LifePointsRegenEndMessage.lifePointsGained.");
         }
    }

}