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
    private Vector<GuildInsiderFactSheetInformations> guilds;
    private Vector<PrismSubareaEmptyInfo> prisms;
    private FuncTree _allianceInfostree;
    private FuncTree _guildstree;
    private FuncTree _prismstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6403;
    }

    public AllianceInsiderInfoMessage initAllianceInsiderInfoMessage(AllianceFactSheetInformations param1,Vector<GuildInsiderFactSheetInformations>  param2,Vector<PrismSubareaEmptyInfo>  param3) {
         this.allianceInfos = param1;
         this.guilds = param2;
         this.prisms = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.allianceInfos = new AllianceFactSheetInformations();
         this.prisms = new Vector.<PrismSubareaEmptyInfo>();
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
         this.serializeAs_AllianceInsiderInfoMessage(param1);
    }

    public void serializeAs_AllianceInsiderInfoMessage(ICustomDataOutput param1) {
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
         this.deserializeAs_AllianceInsiderInfoMessage(param1);
    }

    public void deserializeAs_AllianceInsiderInfoMessage(ICustomDataInput param1) {
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

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceInsiderInfoMessage(param1);
    }

    public void deserializeAsyncAs_AllianceInsiderInfoMessage(FuncTree param1) {
         this._allianceInfostree = param1.addChild(this._allianceInfostreeFunc);
         this._guildstree = param1.addChild(this._guildstreeFunc);
         this._prismstree = param1.addChild(this._prismstreeFunc);
    }

    private void _allianceInfostreeFunc(ICustomDataInput param1) {
         this.allianceInfos = new AllianceFactSheetInformations();
         this.allianceInfos.deserializeAsync(this._allianceInfostree);
    }

    private void _guildstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._guildstree.addChild(this._guildsFunc);
            _loc3_++;
         }
    }

    private void _guildsFunc(ICustomDataInput param1) {
         GuildInsiderFactSheetInformations _loc2_ = new GuildInsiderFactSheetInformations();
         _loc2_.deserialize(param1);
         this.guilds.push(_loc2_);
    }

    private void _prismstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._prismstree.addChild(this._prismsFunc);
            _loc3_++;
         }
    }

    private void _prismsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         PrismSubareaEmptyInfo _loc3_ = ProtocolTypeManager.getInstance(PrismSubareaEmptyInfo,_loc2_);
         _loc3_.deserialize(param1);
         this.prisms.push(_loc3_);
    }

}