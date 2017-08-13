package package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AllianceFactSheetInformations extends AllianceInformations implements INetworkType {

    private int protocolId = 421;
    private int creationDate = 0;


    public int getTypeId() {
         return 421;
    }

    public AllianceFactSheetInformations initAllianceFactSheetInformations(int param1,String  param2,String  param3,GuildEmblem  param4,int  param5) {
         super.initAllianceInformations(param1,param2,param3,param4);
         this.creationDate = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.creationDate = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AllianceFactSheetInformations(param1);
    }

    public void serializeAs_AllianceFactSheetInformations(ICustomDataOutput param1) {
         super.serializeAs_AllianceInformations(param1);
         if(this.creationDate < 0)
            throw new Exception("Forbidden value (" + this.creationDate + ") on element creationDate.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceFactSheetInformations(param1);
    }

    public void deserializeAs_AllianceFactSheetInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._creationDateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceFactSheetInformations(param1);
    }

    public void deserializeAsyncAs_AllianceFactSheetInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._creationDateFunc);
    }

    private void _creationDateFunc(ICustomDataInput param1) {
         this.creationDate = param1.readInt();
         if(this.creationDate < 0)
            throw new Exception("Forbidden value (" + this.creationDate + ") on element of AllianceFactSheetInformations.creationDate.");
    }

}