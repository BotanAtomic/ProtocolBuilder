package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterLightInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class MapRunningFightDetailsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5751;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private GameFightFighterLightInformations[] attackers;
    private GameFightFighterLightInformations[] defenders;
    private FuncTree _attackerstree;
    private FuncTree _defenderstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeInt(this.fightId);
         param1.writeShort(this.attackers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.attackers.length)
         {
            param1.writeShort((this.attackers[_loc2_] as GameFightFighterLightInformations).getTypeId());
            (this.attackers[_loc2_] as GameFightFighterLightInformations).serialize(param1);
            _loc2_++;
         }
         param1.writeShort(this.defenders.length);
         int _loc3_ = 0;
         while(_loc3_ < this.defenders.length)
         {
            param1.writeShort((this.defenders[_loc3_] as GameFightFighterLightInformations).getTypeId());
            (this.defenders[_loc3_] as GameFightFighterLightInformations).serialize(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc6_ = 0;
         GameFightFighterLightInformations _loc7_ = null;
         int _loc8_ = 0;
         GameFightFighterLightInformations _loc9_ = null;
         this.fightId = param1.readInt();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of MapRunningFightDetailsMessage.fightId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations,_loc6_);
            _loc7_.deserialize(param1);
            this.attackers.push(_loc7_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc8_ = param1.readUnsignedShort();
            _loc9_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations,_loc8_);
            _loc9_.deserialize(param1);
            this.defenders.push(_loc9_);
            _loc5_++;
         }
    }

}