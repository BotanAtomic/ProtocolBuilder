package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightCloseCombatMessage extends AbstractGameActionFightTargetedAbilityMessage implements INetworkMessage {

    private int protocolId = 6116;
    private boolean _isInitialized = false;
    private int weaponGenericId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.silentCast);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.verboseCast);
         param1.writeByte(_loc2_);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.destinationCellId < -1 || this.destinationCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.destinationCellId + ") on element destinationCellId.");
         }
         param1.writeShort(this.destinationCellId);
         param1.writeByte(this.critical);
         if(this.weaponGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.weaponGenericId + ") on element weaponGenericId.");
         }
         param1.writeVarShort(this.weaponGenericId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of AbstractGameActionMessage.actionId.");
         }
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of AbstractGameActionMessage.sourceId.");
         }
         int _loc2_ = param1.readByte();
         this.silentCast = BooleanByteWrapper.getFlag(_loc2_,0);
         this.verboseCast = BooleanByteWrapper.getFlag(_loc2_,1);
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of AbstractGameActionFightTargetedAbilityMessage.targetId.");
         }
         this.destinationCellId = param1.readShort();
         if(this.destinationCellId < -1 || this.destinationCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.destinationCellId + ") on element of AbstractGameActionFightTargetedAbilityMessage.destinationCellId.");
         }
         this.critical = param1.readByte();
         if(this.critical < 0)
         {
            throw new Exception("Forbidden value (" + this.critical + ") on element of AbstractGameActionFightTargetedAbilityMessage.critical.");
         }
         this.weaponGenericId = param1.readVarUhShort();
         if(this.weaponGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.weaponGenericId + ") on element of GameActionFightCloseCombatMessage.weaponGenericId.");
         }
    }

}