package package com.ankamagames.dofus.network.messages.game.alliance;

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
import java.lang.Exception;

public class AllianceFactsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6414;
    private boolean _isInitialized = false;
    private AllianceFactSheetInformations infos = ;
    private Vector.<GuildInAllianceInformations> guilds = ;
    private Vector.<uint> controlledSubareaIds = ;
    private Number leaderCharacterId = 0;
    private String leaderCharacterName = "";
    private FuncTree _infostree = ;
    private FuncTree _guildstree = ;
    private FuncTree _controlledSubareaIdstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc8_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = param1.readUnsignedShort();
    private int _loc4_ = 0;
    private int _loc5_ = param1.readUnsignedShort();
    private int _loc6_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6414;
    }

    public AllianceFactsMessage initAllianceFactsMessage(AllianceFactSheetInformations param1,Vector.<GuildInAllianceInformations>  param2,Vector.<uint>  param3,Number  param4,String  param5) {
         this.infos = param1;
         this.guilds = param2;
         this.controlledSubareaIds = param3;
         this.leaderCharacterId = param4;
         this.leaderCharacterName = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.infos = new AllianceFactSheetInformations();
         this.controlledSubareaIds = new Vector.<uint>();
         this.leaderCharacterId = 0;
         this.leaderCharacterName = "";
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
         this.serializeAs_AllianceFactsMessage(param1);
    }

    public void serializeAs_AllianceFactsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.infos.getTypeId());
         this.infos.serialize(param1);
         param1.writeShort(this.guilds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.guilds.length)
            (this.guilds[_loc2_] as GuildInAllianceInformations).serializeAs_GuildInAllianceInformations(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceFactsMessage(param1);
    }

    public void deserializeAs_AllianceFactsMessage(ICustomDataInput param1) {
         GuildInAllianceInformations _loc7_ = null;
         int _loc8_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         this.infos = ProtocolTypeManager.getInstance(AllianceFactSheetInformations,_loc2_);
         this.infos.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
            _loc7_ = new GuildInAllianceInformations();
            _loc7_.deserialize(param1);
            this.guilds.push(_loc7_);
            _loc4_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceFactsMessage(param1);
    }

    public void deserializeAsyncAs_AllianceFactsMessage(FuncTree param1) {
         this._infostree = param1.addChild(this._infostreeFunc);
         this._guildstree = param1.addChild(this._guildstreeFunc);
         this._controlledSubareaIdstree = param1.addChild(this._controlledSubareaIdstreeFunc);
         param1.addChild(this._leaderCharacterIdFunc);
         param1.addChild(this._leaderCharacterNameFunc);
    }

    private void _infostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.infos = ProtocolTypeManager.getInstance(AllianceFactSheetInformations,_loc2_);
         this.infos.deserializeAsync(this._infostree);
    }

    private void _guildstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._guildstree.addChild(this._guildsFunc);
            _loc3_++;
    }

    private void _guildsFunc(ICustomDataInput param1) {
         GuildInAllianceInformations _loc2_ = new GuildInAllianceInformations();
         _loc2_.deserialize(param1);
         this.guilds.push(_loc2_);
    }

    private void _controlledSubareaIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._controlledSubareaIdstree.addChild(this._controlledSubareaIdsFunc);
            _loc3_++;
    }

    private void _controlledSubareaIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of controlledSubareaIds.");
    }

    private void _leaderCharacterIdFunc(ICustomDataInput param1) {
         this.leaderCharacterId = param1.readVarUhLong();
         if(this.leaderCharacterId < 0 || this.leaderCharacterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.leaderCharacterId + ") on element of AllianceFactsMessage.leaderCharacterId.");
    }

    private void _leaderCharacterNameFunc(ICustomDataInput param1) {
         this.leaderCharacterName = param1.readUTF();
    }

}