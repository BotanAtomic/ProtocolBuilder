package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class PrismFightDefenderAddMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5895;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private int fightId = 0;
    private CharacterMinimalPlusLookInformations defender;
    private FuncTree _defendertree;


    public void serialize(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeVarShort(this.fightId);
         param1.writeShort(this.defender.getTypeId());
         this.defender.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismFightDefenderAddMessage.subAreaId.");
         }
         this.fightId = param1.readVarUhShort();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of PrismFightDefenderAddMessage.fightId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.defender = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations,_loc2_);
         this.defender.deserialize(param1);
    }

}