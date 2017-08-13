package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.DungeonPartyFinderPlayer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DungeonPartyFinderRoomContentUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6250;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private DungeonPartyFinderPlayer[] addedPlayers;
    private Number[] removedPlayersIds;
    private FuncTree _addedPlayerstree;
    private FuncTree _removedPlayersIdstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
         param1.writeShort(this.addedPlayers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.addedPlayers.length)
         {
            (this.addedPlayers[_loc2_] as DungeonPartyFinderPlayer).serializeAs_DungeonPartyFinderPlayer(param1);
            _loc2_++;
         }
         param1.writeShort(this.removedPlayersIds.length);
         int _loc3_ = 0;
         while(_loc3_ < this.removedPlayersIds.length)
         {
            if(this.removedPlayersIds[_loc3_] < 0 || this.removedPlayersIds[_loc3_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.removedPlayersIds[_loc3_] + ") on element 3 (starting at 1) of removedPlayersIds.");
            }
            param1.writeVarLong(this.removedPlayersIds[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         DungeonPartyFinderPlayer _loc6_ = null;
         Object _loc7_ = NaN;
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of DungeonPartyFinderRoomContentUpdateMessage.dungeonId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new DungeonPartyFinderPlayer();
            _loc6_.deserialize(param1);
            this.addedPlayers.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhLong();
            if(_loc7_ < 0 || _loc7_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of removedPlayersIds.");
            }
            this.removedPlayersIds.push(_loc7_);
            _loc5_++;
         }
    }

}