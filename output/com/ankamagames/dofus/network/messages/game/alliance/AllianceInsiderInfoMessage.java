package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.AllianceFactSheetInformations;
import com.ankamagames.dofus.network.types.game.social.GuildInsiderFactSheetInformations;
import com.ankamagames.dofus.network.types.game.prism.PrismSubareaEmptyInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class AllianceInsiderInfoMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6403;
    private boolean _isInitialized = false;
    private AllianceFactSheetInformations allianceInfos;
    private GuildInsiderFactSheetInformations[] guilds;
    private PrismSubareaEmptyInfo[] prisms;
    private FuncTree _allianceInfostree;
    private FuncTree _guildstree;
    private FuncTree _prismstree;


    public void serialize(ICustomDataOutput param1) {
         this.allianceInfos.serializeAs_AllianceFactSheetInformations(param1);
         param1.writeShort(this.guilds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.guilds.length)
         {
            (this.guilds[_loc2_] as GuildInsiderFactSheetInformations).serializeAs_GuildInsiderFactSheetInformations(param1);
            _loc2_++;
         }
         param1.writeShort(this.prisms.length);
         int _loc3_ = 0;
         while(_loc3_ < this.prisms.length)
         {
            param1.writeShort((this.prisms[_loc3_] as PrismSubareaEmptyInfo).getTypeId());
            (this.prisms[_loc3_] as PrismSubareaEmptyInfo).serialize(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         GuildInsiderFactSheetInformations _loc6_ = null;
         int _loc7_ = 0;
         PrismSubareaEmptyInfo _loc8_ = null;
         this.allianceInfos = new AllianceFactSheetInformations();
         this.allianceInfos.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new GuildInsiderFactSheetInformations();
            _loc6_.deserialize(param1);
            this.guilds.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readUnsignedShort();
            _loc8_ = ProtocolTypeManager.getInstance(PrismSubareaEmptyInfo,_loc7_);
            _loc8_.deserialize(param1);
            this.prisms.push(_loc8_);
            _loc5_++;
         }
    }

}