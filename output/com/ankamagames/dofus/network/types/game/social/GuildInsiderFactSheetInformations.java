package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildInsiderFactSheetInformations extends GuildFactSheetInformations implements INetworkType {

    private int protocolId = 423;
    private String leaderName = "";
    private int nbConnectedMembers = 0;
    private int nbTaxCollectors = 0;
    private int lastActivity = 0;


    public int getTypeId() {
         return 423;
    }

    public GuildInsiderFactSheetInformations initGuildInsiderFactSheetInformations(int param1,String  param2,int  param3,GuildEmblem  param4,Number  param5,int  param6,String  param7,int  param8,int  param9,int  param10) {
         super.initGuildFactSheetInformations(param1,param2,param3,param4,param5,param6);
         this.leaderName = param7;
         this.nbConnectedMembers = param8;
         this.nbTaxCollectors = param9;
         this.lastActivity = param10;
         return this;
    }

    public void reset() {
         super.reset();
         this.leaderName = "";
         this.nbConnectedMembers = 0;
         this.nbTaxCollectors = 0;
         this.lastActivity = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildInsiderFactSheetInformations(param1);
    }

    public void serializeAs_GuildInsiderFactSheetInformations(ICustomDataOutput param1) {
         super.serializeAs_GuildFactSheetInformations(param1);
         param1.writeUTF(this.leaderName);
         if(this.nbConnectedMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbConnectedMembers + ") on element nbConnectedMembers.");
         }
         param1.writeVarShort(this.nbConnectedMembers);
         if(this.nbTaxCollectors < 0)
         {
            throw new Exception("Forbidden value (" + this.nbTaxCollectors + ") on element nbTaxCollectors.");
         }
         param1.writeByte(this.nbTaxCollectors);
         if(this.lastActivity < 0)
         {
            throw new Exception("Forbidden value (" + this.lastActivity + ") on element lastActivity.");
         }
         param1.writeInt(this.lastActivity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInsiderFactSheetInformations(param1);
    }

    public void deserializeAs_GuildInsiderFactSheetInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._leaderNameFunc(param1);
         this._nbConnectedMembersFunc(param1);
         this._nbTaxCollectorsFunc(param1);
         this._lastActivityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInsiderFactSheetInformations(param1);
    }

    public void deserializeAsyncAs_GuildInsiderFactSheetInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._leaderNameFunc);
         param1.addChild(this._nbConnectedMembersFunc);
         param1.addChild(this._nbTaxCollectorsFunc);
         param1.addChild(this._lastActivityFunc);
    }

    private void _leaderNameFunc(ICustomDataInput param1) {
         this.leaderName = param1.readUTF();
    }

    private void _nbConnectedMembersFunc(ICustomDataInput param1) {
         this.nbConnectedMembers = param1.readVarUhShort();
         if(this.nbConnectedMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbConnectedMembers + ") on element of GuildInsiderFactSheetInformations.nbConnectedMembers.");
         }
    }

    private void _nbTaxCollectorsFunc(ICustomDataInput param1) {
         this.nbTaxCollectors = param1.readByte();
         if(this.nbTaxCollectors < 0)
         {
            throw new Exception("Forbidden value (" + this.nbTaxCollectors + ") on element of GuildInsiderFactSheetInformations.nbTaxCollectors.");
         }
    }

    private void _lastActivityFunc(ICustomDataInput param1) {
         this.lastActivity = param1.readInt();
         if(this.lastActivity < 0)
         {
            throw new Exception("Forbidden value (" + this.lastActivity + ") on element of GuildInsiderFactSheetInformations.lastActivity.");
         }
    }

}