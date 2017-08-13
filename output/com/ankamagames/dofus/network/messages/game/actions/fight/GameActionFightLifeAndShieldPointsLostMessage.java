package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightLifeAndShieldPointsLostMessage extends GameActionFightLifePointsLostMessage implements INetworkMessage {

    private int protocolId = 6310;
    private boolean _isInitialized = false;
    private int shieldLoss = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.loss < 0)
         {
            throw new Exception("Forbidden value (" + this.loss + ") on element loss.");
         }
         param1.writeVarInt(this.loss);
         if(this.permanentDamages < 0)
         {
            throw new Exception("Forbidden value (" + this.permanentDamages + ") on element permanentDamages.");
         }
         param1.writeVarInt(this.permanentDamages);
         if(this.shieldLoss < 0)
         {
            throw new Exception("Forbidden value (" + this.shieldLoss + ") on element shieldLoss.");
         }
         param1.writeVarShort(this.shieldLoss);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightLifePointsLostMessage(param1);
         this.shieldLoss = param1.readVarUhShort();
         if(this.shieldLoss < 0)
         {
            throw new Exception("Forbidden value (" + this.shieldLoss + ") on element of GameActionFightLifeAndShieldPointsLostMessage.shieldLoss.");
         }
    }

}