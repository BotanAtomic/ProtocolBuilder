package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.AllianceFactSheetInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class AllianceFactsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6414;
    private boolean _isInitialized = false;
    private AllianceFactSheetInformations infos;
    private GuildInAllianceInformations[] guilds;
    private int[] controlledSubareaIds;
    private Number leaderCharacterId = 0;
    private String leaderCharacterName = "";
    private FuncTree _infostree;
    private FuncTree _guildstree;
    private FuncTree _controlledSubareaIdstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.infos.getTypeId());
         this.infos.serialize(param1);
         param1.writeShort(this.guilds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.guilds.length)
         {
            (this.guilds[_loc2_] as GuildInAllianceInformations).serializeAs_GuildInAllianceInformations(param1);
            _loc2_++;
         }
         param1.writeShort(this.controlledSubareaIds.length);
         int _loc3_ = 0;
         while(_loc3_ < this.controlledSubareaIds.length)
         {
            if(this.controlledSubareaIds[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.controlledSubareaIds[_loc3_] + ") on element 3 (starting at 1) of controlledSubareaIds.");
            }
            param1.writeVarShort(this.controlledSubareaIds[_loc3_]);
            _loc3_++;
         }
         if(this.leaderCharacterId < 0 || this.leaderCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderCharacterId + ") on element leaderCharacterId.");
         }
         param1.writeVarLong(this.leaderCharacterId);
         param1.writeUTF(this.leaderCharacterName);
    }

    public void deserialize(ICustomDataInput param1) {
         GuildInAllianceInformations _loc7_ = null;
         int _loc8_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         this.infos = ProtocolTypeManager.getInstance(AllianceFactSheetInformations,_loc2_);
         this.infos.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
         {
            _loc7_ = new GuildInAllianceInformations();
            _loc7_.deserialize(param1);
            this.guilds.push(_loc7_);
            _loc4_++;
         }
         int _loc5_ = param1.readUnsignedShort();
         int _loc6_ = 0;
         while(_loc6_ < _loc5_)
         {
            _loc8_ = param1.readVarUhShort();
            if(_loc8_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc8_ + ") on elements of controlledSubareaIds.");
            }
            this.controlledSubareaIds.push(_loc8_);
            _loc6_++;
         }
         this.leaderCharacterId = param1.readVarUhLong();
         if(this.leaderCharacterId < 0 || this.leaderCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderCharacterId + ") on element of AllianceFactsMessage.leaderCharacterId.");
         }
         this.leaderCharacterName = param1.readUTF();
    }

}